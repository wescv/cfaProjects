// Define the customer data
var customerData = [
    {"id":1,"firstName":"Rui","lastName":"Ferrão","email":"rui@gmail.com","phone":"777888"},
    {"id":2,"firstName":"Sergio","lastName":"Gouveia","email":"sergio@gmail.com","phone":"777999"},
    {"id":3,"firstName":"Bruno","lastName":"Ferreira","email":"bruno@gmail.com","phone":"777666"},
    {"id":4,"firstName":"Rodolfo","lastName":"Matos","email":"rodolfo@gmail.com","phone":"777333"}
];

// Function to fill the HTML table
function fillTable() {
    var table = document.getElementById('customerTable');

    // Loop through the customer data
    customerData.forEach(function(customer) {
        var row = table.insertRow();
        var cellFirstName = row.insertCell(0);
        cellFirstName.innerHTML = customer.firstName;

        var cellLastName = row.insertCell(1);
        cellLastName.innerHTML = customer.lastName;

        var cellEmail = row.insertCell(2);
        cellEmail.innerHTML = customer.email;

        var cellPhone = row.insertCell(3);
        cellPhone.innerHTML = customer.phone;

        var cellEdit = row.insertCell(4);
        var editButton = document.createElement('button');
        editButton.innerHTML = 'Edit';
        editButton.addEventListener('click', function() {
            openEditWindow(customer);
        });
        cellEdit.appendChild(editButton);

        var cellDelete = row.insertCell(5);
        var deleteButton = document.createElement('button');
        deleteButton.innerHTML = 'Delete';
        deleteButton.addEventListener('click', function() {
            deleteCustomer(customer, row);
        });
        cellDelete.appendChild(deleteButton);
    });
}

// Function to open the edit window
function openEditWindow(customer) {
    // For simplicity, I'll use the prompt function to get the edited values
    var editedFirstName = prompt('Enter the edited first name:', customer ? customer.firstName : '');
    var editedLastName = prompt('Enter the edited last name:', customer ? customer.lastName : '');

    // If the user didn't cancel the prompt, update the customer data
    if (editedFirstName !== null && editedLastName !== null) {
        if (customer) {
            // Update existing customer
            customer.firstName = editedFirstName;
            customer.lastName = editedLastName;
            // You can add AJAX logic here to send the updated data to the server
        } else {
            // Create a new customer
            var newCustomer = {
                id: customerData.length + 1,
                firstName: editedFirstName,
                lastName: editedLastName,
                email: '', // You can add prompts for email and phone as well
                phone: ''
            };
            customerData.push(newCustomer);
            // You can add AJAX logic here to send the new customer data to the server
        }

        // Clear the table and fill it again with the updated data
        clearTable();
        fillTable();
    }
}

// Function to delete a customer
function deleteCustomer(customer, row) {
    // You can add AJAX logic here to send a delete request to the server

    // Remove the row from the table
    var table = document.getElementById('customerTable');
    table.deleteRow(row.rowIndex);
}

// Function to clear the HTML table
function clearTable() {
    var table = document.getElementById('customerTable');
    while (table.rows.length > 1) {
        table.deleteRow(1);
    }
}

// Call the function to fill the table
fillTable();
