var API_URL = 'http://localhost:8080/javabank5/api/customer';

var deleteCustomer;

$(document).ready(function () {
    fetchCustomers();

});

function fetchCustomers() {
    $.ajax({
        url: API_URL,
        async: true,
        success: successCallback,
        error: errorCallback
    });
}

function successCallback(response) {
    populateCustomers(response);
    
    console.log(response);
}

function errorCallback(request, status, error) {
    console.log(request);
    console.log(status);
    console.log(error);
}

function populateCustomers(customerData) {
    var customersTable = $('#customer-table');

    customerData.forEach(function (element) {
        var elementStr =
            "<tr>" +
            "<td>" + element.firstName + "</td>" +
            "<td>" + element.lastName + "</td>" +
            "<td>" + element.email + "</td>" +
            "<td>" + element.phone + "</td>" +
            '<td><button type="button" onclick="editCustomer(' + element.id + ')" class="edit-btn btn btn-success">Edit</button></td>' +
            '<td><button type="button" onclick="deleteCustomer(' + element.id + ')" class="remove-btn btn btn-danger">Delete</button></td>' +
            "</tr>";

        $(elementStr).appendTo(customersTable);
        console.log(API_URL + "/" + element.id)
    });
}

function editCustomer(customerId) {
    var editForm = $('#editForm');
    console.log("Edit button clicked for ID: " + customerId);


    $.ajax({
        url: API_URL + '/' + customerId,
        type: 'GET',
        success: function (customer) {
            
            editForm.find('#firstName').val(customer.firstName);
            editForm.find('#lastName').val(customer.lastName);
            editForm.find('#email').val(customer.email);
            editForm.find('#phone').val(customer.phone);

        },
        error: function (request, status, error) {
            console.error("Error fetching customer details for editing:", request, status, error);
        }
    });

    $('#saveChangesBtn').on('click', function () {
        var updatedData = {
            firstName: editForm.find('#firstName').val(),
            lastName: editForm.find('#lastName').val(),
            email: editForm.find('#email').val(),
            phone: editForm.find('#phone').val()
        };

        updateData(customerId, updatedData);
    });


}

function deleteCustomer(customerId) {
    var confirmDelete = confirm("Are you sure you want to delete this customer?");

    if (confirmDelete) {

        $.ajax({
            url: API_URL + '/' + customerId,
            type: 'DELETE',
            success: function (response) {
                console.log("Customer deleted successfully:", response);
                $('#remove-btn-' + customerId).remove();
                location.reload();
            },
            error: function (request, status, error) {
                console.error("Error deleting customer:", request, status, error);
            }
        });
    }
}

function addData() {
    
    $.ajax({
        url: API_URL,
        type: 'POST',
        contentType: 'application/json',
        async: true,
        data: JSON.stringify({
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            email: $('#email').val(),
            phone: $('#phone').val()
        }),
        success: function (response) {
            console.log("Customer added successfully:", response);
            successCallback();
            
        },
        error: function (request, status, error) {
            console.error("Error adding customer:", request, status, error);
        }
        
    });
    location.reload();
}


function updateData(customerId, updatedData) {

    $.ajax({
        url: API_URL + '/' + customerId,
        type: 'PUT', 
        contentType: 'application/json',
        data: JSON.stringify(updatedData),

        success: function (response) {
            console.log("Customer updated successfully:", response);
            updateCustomerInList(customerId, updatedData);
           
        },
        error: function (request, status, error) {
            console.error("Error updating customer:", request, status, error);
        }
    });
}

function updateCustomerInList(customerId, updatedData) {
    
    var customerRow = $('#remove-btn-' + customerId).closest('tr');
    customerRow.find('td:eq(0)').text(updatedData.firstName);
    customerRow.find('td:eq(1)').text(updatedData.lastName);
    customerRow.find('td:eq(2)').text(updatedData.email);
    customerRow.find('td:eq(3)').text(updatedData.phone);
}

