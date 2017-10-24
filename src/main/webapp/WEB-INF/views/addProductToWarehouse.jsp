<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add product to Warehouse</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        $("#products").hide();
        function sendData() {


            var json = {
                "warehouseId":$("#warehouse option:selected").val(),
                "productId": $("#products option:selected").val(),
                "sizeId": $("#productsSize option:selected").val(),
            };

            $.ajax({
                url: '/admin/warehouse/addProduct',
                type: 'POST',
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success: function () {
                    alert("Product added Successfull: ");
                },
                error: function () {
                    alert(" Failed to Add product in warehouse ");
                }
            });

        }
        function serachWarehouse(value) {
            var key = null;
            key = document.getElementById('warehouseName').value;

            var json = {
                "key": key,
                "warehouse": true,
            };
            $.ajax({
                url: '/admin/search',
                type: 'POST',
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    console.log(data.object[0].id);
                    if(data.object.length > 0) {
                        for (var i = 0; i < data.object.length; i++) {
                            var option = $('<option value="'+data.object[i].id+'" >'+data.object[i].warehouseName+'</option>');
                            $('#warehouse').append(option);
                        }
                    }else{
                        $("#warehouse").hide();
                        var option = $('<option value="" ></option>');
                        $('#warehouse').append(option);
                    }

                },
                error: function () {
                    alert(" failed service: ", json);
                }
            });
        }

        function serach(value) {
            var abc = [];
            var product = false;
            var warehouse = false;
            var size = false;
            var key = null;
            productId = null;

            if (document.getElementById('productName').value) {
                product = true;
                warehouse = false;
                size = false;
                key = value;

            } else if (document.getElementById('warehouseName').value) {
                product = false;
                warehouse = true;
                size = false;
                key = value;

            } else if (document.getElementById('products').value) {
                product = false;
                warehouse = false;
                size = true;
                key = null;
                productId = value;
            }
            var json1 = {
                "product": product,
                "warehouseName": warehouse,
                "size": size,
                "key": key
            };

            var json = {
                "product": product,
                "warehouse": warehouse,
                "size": size,
                "key":key,
                "productId": productId
            };
            $.ajax({
                url: '/admin/search',
                type: 'POST',
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    console.log(data.object[0].id);
                    if(data.object.length > 0) {
                        for (var i = 0; i < data.object.length; i++) {
                            var option = $('<option value="'+data.object[i].id+'" >'+data.object[i].productName+'</option>');
                            $('#products').append(option);
                        }
                    }else{
                        $("#products").hide();
                        var option = $('<option value="" ></option>');
                        $('#products').append(option);
                    }

                },
                error: function () {
                    alert(" failed service: ", json);
                }
            });
        }

            function dropdownValue() {
                $("option").remove('#productsize')
                var dropdownProduct = $("#products option:selected").val();
                var json = {
                    "productId": dropdownProduct,
                    "size": true
                };
                $.ajax({
                    url: '/admin/search',
                    type: 'POST',
                    data: JSON.stringify(json),
                    dataType: "json",
                    contentType: "application/json",
                    success: function (data) {
                            for (var i = 0; i < data.object.length; i++) {
                                console.log(data.object[i].productSize);
                                var option = $('<option value="' + data.object[i].id + '" id="productsize" >' + data.object[i].productSize + '</option>');
                                $('#productsSize').append(option);
                            }

                    },
                    error: function () {
                        alert(" failed service: ", json);
                    }
                });
            }
    </script>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="2" bgcolor="#00ced1" align="center">
    <thead>
    <tr align="center">
        <th colspan="2">Add Product To Warehouse</th>
    </tr>
    </thead>
    <tbody>
<c:set var="user" value="${command}"></c:set>
<tr>
    <td>Warehouse Name:</td>
    <td>
    <input type="text" id="warehouseName" class="searchField" onkeyup="serachWarehouse(this.value)">
    <select id="warehouse" style="width: 100px;" ></select><br>
    </td>
</tr>
<tr>
    <td>
        Product Name:
    </td>
    <td>
        <input type="text" id="productName"  class="searchField" name="productName" onkeyup="serach(this.value)"/>
        <select id="products" style="width: 100px;" onchange="dropdownValue()"></select><br>
    </td>
</tr>
<tr>
    <td>
        Product Size:
    </td>
    <td>
        <select id="productsSize" style="width: 100px;" onchange="dropdownValue()"></select><br>
    </td>
</tr>
<tr>
    <td></td>
    <td>
<button type="submit" onclick="sendData()">Add product to Warehouse</button>
<form action="../back">
    <button type="submit">Back</button>
</form>
    </td>
</tr>
    </tbody>
</table>
</body>
</html>