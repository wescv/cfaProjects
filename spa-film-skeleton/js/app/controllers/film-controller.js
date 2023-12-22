define(['views/film-view', 'services/film-service'], function(
    filmView,
    filmService
) {
    var externals = {};
    var internals = {};

    externals.start = function() {
        internals.bindEventHandlers();
        filmView.render();
    };

    internals.bindEventHandlers = function() {
        filmView.bind('button', internals.buttonHandler);
    };

    internals.buttonHandler = function() {
        var filmIndex = Math.floor(Math.random() * 6);
        filmService.getFilm(filmIndex, function(film) {
            filmView.render(film);
        });
    };

    return externals;
});
