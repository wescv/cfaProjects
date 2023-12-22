define(['views/trivia-view', 'services/trivia-service', 'jquery'], function(triviaView, triviaService, $) {
    var TriviaController = {};

    TriviaController.init = function() {
        triviaView.bind('button', TriviaController.buttonHandler);
        triviaView.bind('check-answer', TriviaController.checkAnswerHandler);
        triviaView.bind('answer-option', TriviaController.answerOptionHandler);
            
        triviaView.init();
    };

    TriviaController.buttonHandler = function() {
        var numberOfQuestions = 1; 
        triviaService.getTriviaQuestions(numberOfQuestions, function(questions) {
            TriviaController.currentQuestion = questions[0];
            triviaView.render(TriviaController.currentQuestion);
        });
    };

    TriviaController.checkAnswerHandler = function() {
        if (!TriviaController.currentQuestion) {
            console.error('No current question to check.');
            return;
        }

        var selectedOption = triviaView.getSelectedOption();
        var correctAnswer = TriviaController.currentQuestion.correct_answer;

        if (selectedOption === correctAnswer) {
            triviaView.showResult('CORRECT');
        } else {
            triviaView.showResult('WRONG');
        }
    };

    TriviaController.answerOptionHandler = function(e) {
        var selectedOption = $(e.currentTarget).text();
        triviaView.setSelectedOption(selectedOption);
    };

    return TriviaController;
});
