<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Other/html.html to edit this template
-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Home Page</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }
    </style>
    <%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="DataAccess.RetailerDTO" %>
<%@ page import="DataAccess.RetailerDAO" %>
<%@ page import="DataAccess.RetailerDAOImpl" %>

<body>
    <div class="container">
        <h1>Retailer List</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    RetailerDAO retailerDAO = new RetailerDAOImpl();
                    List<RetailerDTO> retailers = retailerDAO.getAllRetailers();

                    if (retailers != null && !retailers.isEmpty()) {
                        for (RetailerDTO retailer : retailers) {
                %>
                    <tr>
                        <td><%= retailer.getRetailerId() %></td>
                        <td><%= retailer.getRetailerName() %></td>
                        <td><%= retailer.getRetailerDescription() %></td>
                        <td><a href="ViewRetailerServlet?retailer_id=<%= retailer.getRetailerId() %>">View Retailer Page</a></td>
                    </tr>
                <% 
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="4" class="no-data">No retailers found.</td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>

