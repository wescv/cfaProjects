var expect = require('expect.js');
var sinon = require('sinon');
var callbacksAnswers = require('../../src/01-callbacks');

describe('callbacks', function() {
    var originalPromise = global.Promise;
    var clock;

    beforeEach(function() {
        clock = sinon.useFakeTimers();
    });

    afterEach(function() {
        clock.restore();
        global.Promise = originalPromise;
    });

    it('you should understand how to use callbacks synchronously', function() {
        var called = false;
        var testDelay = 10000;

        var result = callbacksAnswers.profileFunc(function() {
            clock.tick(testDelay);
            called = true;
        });

        expect(called).to.equal(true);
        expect(result).to.equal(testDelay);
    });

    it('you should understand how to understand how to use callbacks to handle asynchronicity', function() {
        var value = {};
        var validateTime = false;
        var called = false;
        var testTime = 10000;

        var result = callbacksAnswers.returnWithDelay(value, testTime, function(
            error,
            data
        ) {
            called = true;

            expect(error).to.not.be.ok();
            expect(data).to.equal(value);
            expect(validateTime).to.be(true);
        });

        expect(result).to.be(undefined);
        clock.tick(testTime - 1);
        validateTime = true;
        clock.tick(1);
        expect(called).to.be(true);
    });

    it('you should understand how to pass errors from inside an asynchronous callback', function() {
        var validateTime = false;
        var called = false;
        var testTime = 10000;

        var result = callbacksAnswers.failWithDelay(testTime, function(
            error,
            data
        ) {
            called = true;

            expect(error).to.be.an(Error);
            expect(validateTime).to.be(true);
        });

        expect(result).to.be(undefined);
        clock.tick(testTime - 1);
        validateTime = true;
        clock.tick(1);
        expect(called).to.be(true);
    });

    it('you should understand how to use promises to wrap APIs that are not promise based', function() {
        var testTime = 10000;
        var resolved = false;
        var rejected = false;

        // monkey patch the global promise object
        var FakePromise = Promise.resolve();
        global.Promise = function(cb) {
            cb(
                function() {
                    resolved = true;
                },
                function() {
                    rejected = true;
                }
            );

            this.isPromise = Promise;
        };
        global.Promise.resolve = function() {
            resolved = true;
        };
        global.Promise.reject = function() {
            rejected = true;
        };
        // end monkey patching

        var promise = callbacksAnswers.promiseBasedDelay(testTime);
        expect(promise.isPromise || promise).to.equal(Promise);

        clock.tick(testTime - 1);
        expect(resolved).to.be(false);
        expect(rejected).to.be(false);

        clock.tick(1);
        expect(resolved).to.be(true);
        expect(rejected).to.be(false);

        promise = callbacksAnswers.promiseBasedDelay(-1);
        expect(rejected).to.be(true);

        promise = callbacksAnswers.promiseBasedDelay();
        expect(rejected).to.be(true);
    });

    it('should understand how to use promise returning APIs', function(done) {
        var url1 = 'http://www.url1.com';
        var url2 = 'http://www.url2.com';
        var resp1 = 'url1-data';
        var resp2 = 'url2-data';
        var resolved = false;
        var called = 0;

        global.fetch = function() {};

        var fakeFetch = sinon.stub(global, 'fetch');
        fakeFetch.withArgs(url1).callsFake(function() {
            called++;
            return Promise.resolve(resp1);
        });
        fakeFetch.withArgs(url2).callsFake(function() {
            called++;
            return Promise.resolve(resp2);
        });

        var promise = callbacksAnswers.concatBodies(url1, url2);
        promise.then(function(result) {
            expect(result).to.equal(resp1 + resp2);
            expect(called).to.equal(2);
            done();
        });
    });
});
