const API_URL = "https://pokeapi.co/api/v2/ability/?limit=10";

window.onload = function () {
    ajaxRequest();
}

function ajaxRequest() {
    var httpRequest;

    if (window.XMLHttpRequest) {
        // Mozilla, Safari, IE7+ ...
        httpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        // IE 6 and older
        httpRequest = new ActiveXObject('Microsoft.XMLHTTP');
    }
    // start the AJAX request
    httpRequest.open('GET', API_URL, true);
    httpRequest.setRequestHeader('Content-type', 'application/json');
    httpRequest.send();

    // run this when the ajax request completes
    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            apiData = httpRequest.responseText;
            console.log("DONE!!")
            console.log(typeof apiData)
            var parseJson = JSON.parse(httpRequest.responseText)
            console.log(parseJson)
        }
    }
};
