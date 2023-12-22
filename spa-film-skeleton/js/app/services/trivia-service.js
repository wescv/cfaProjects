

define(['jquery'], function($) {
    var internals = {};
    var externals = {};

    externals.getTriviaQuestions = function(cb) {
        var apiUrl = 'https://opentdb.com/api.php?amount=10';

        $.ajax({
            url: apiUrl,
            method: 'GET',
            dataType: 'json',
            success: function(data) {
                if (data.results && data.results.length > 0) {
                    cb(data.results);
                } else {
                    console.error('Error: No questions found');
                    cb([]);
                }
            },
            error: function(xhr, status, error) {
                console.error('Error fetching trivia questions:', status, error);
                cb([]);
            }
        });
    };

    return externals;
});
