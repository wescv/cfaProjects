function createCustomerTableAjax() {
    var httpRequest;
    var apiData;
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        httpRequest = new ActiveXObject('Microsoft.XMLHTTP');
    }
    httpRequest.open('GET', 'http://localhost:8080/javabank5/api/customer', true);
    httpRequest.setRequestHeader('Content-type', 'application/json');
    httpRequest.send();
    httpRequest.onreadystatechange = function () {
           if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            console.log('entrou')
            apiData = httpRequest.responseText;
            console.log(apiData);
            console.log(typeof apiData);
            parseJson = JSON.parse(apiData);
            console.log(parseJson)
            console.log(typeof parseJson);
            var customerTable = document.getElementById("customerTable").getElementsByTagName('tbody')[0];
            parseJson.forEach(function (customer) {
                var row = customerTable.insertRow();
                Object.keys(customer).forEach(function (key) {
                    var cell = row.insertCell();
                    cell.textContent = customer[key];
                });
                var editCell = row.insertCell();
                var deleteCell = row.insertCell();
                var editButton = document.createElement("button");
                editButton.textContent = "Edit";
                editButton.classList.add("btn", "btn-primary"); // Adding Bootstrap classes
                editButton.addEventListener("click", function () {
                    alert("Edit clicked for ID: " + customer.id);
                });
                editCell.appendChild(editButton);
                var deleteButton = document.createElement("button");
                deleteButton.textContent = "Delete";
                deleteButton.classList.add("btn", "btn-danger"); // Adding Bootstrap classes
                deleteButton.addEventListener("click", function () {
                    alert("Delete clicked for ID: " + customer.id);
                });
                deleteCell.appendChild(deleteButton);
            });
        }
    };
}
document.addEventListener("DOMContentLoaded", createCustomerTableAjax);
//document.addEventListener("DOMContentLoaded", createCustomerTable);