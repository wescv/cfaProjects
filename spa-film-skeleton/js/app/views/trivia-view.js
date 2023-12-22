define(['jquery'], function ($) {
    var internals = {
        handlers: {},
        elements: {}
    };

    var externals = {};

    internals.createButton = function () {
        return '<button class="random-trivia">Click Me for Random Trivia</button>';
    };

    internals.createTriviaCard = function (question) {
        var optionsHtml = '';

        console.log("e aqui?")
        if (question.type === 'multiple') {
            optionsHtml = '<div class="answer-options">';
            question.options.forEach(function (option, index) {
                optionsHtml += '<div class="answer-option" data-index="' + index + '">' + option + '</div>';
                console.log("multiple questions")
            });
            optionsHtml += '</div>';
        }

        return (
            '<div>' +
            '<h2>' + question.category + '</h2>' +
            '<p><strong>Difficulty: </strong>' + question.difficulty + '</p>' +
            '<p><strong>Question: </strong>' + question.question + '</p>' +
            optionsHtml +
            '<p class="correct-answer"><strong>Correct Answer: </strong>' +
            question.correct_answer +
            '</p>' +
            '<button class="check-answer">Check Answer</button>' +
            '</div>'
        );
    };

    internals.renderTrivia = function (question) {
        if (internals.elements.triviaCard) {
            internals.elements.triviaCard.empty();
        }

        internals.elements.triviaCard = $(internals.createTriviaCard(question));
        internals.elements.app.append(internals.elements.triviaCard);

        internals.elements.app.find('.check-answer').click(internals.handlers['check-answer']);
        internals.elements.app.find('.answer-option').click(internals.handlers['answer-option']);
    };

    internals.renderButton = function () {
        if (internals.elements.button) {
            return;
        }

        internals.elements.button = $(internals.createButton());
        internals.elements.button.click(internals.handlers['button']);
        internals.elements.app.append(internals.elements.button);
    };

    externals.bind = function (event, handler) {
        internals.handlers[event] = handler;
    };

    externals.render = function (question) {
        internals.elements.app = $('#app');
        internals.renderButton();

        if (question) {
            internals.renderTrivia(question);
        }
    };

    return externals;
});
