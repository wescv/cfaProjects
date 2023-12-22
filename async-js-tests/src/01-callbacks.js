/**
 * Invoke the callback and return the amount of time in miliseconds it took to execute
 */
exports.profileFunc = function(cb) {
    const startTime = Date.now();
  cb();
  const endTime = Date.now();
  return endTime - startTime;
};

/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function(value, delay, cb) {};

/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function(delay, cb) {};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function(delay) {};

/**
 * Use fetch to grab the contents of both urls and return
 * a promise resolving to the payload concatenation
 */
exports.concatBodies = function(url1, url2) {};
