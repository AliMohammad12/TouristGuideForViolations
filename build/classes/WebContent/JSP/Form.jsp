<!DOCTYPE html>
<html>
<head>
    <style>
        body {
        
            background-color: white;
            background-image: url('stars.png');
        }

        form {
            margin: 0 auto;
            width: 500px;
            padding: 40px;
            background-color: #222222;
            color: white;
            border-radius: 50px;
        }

        .form-group {
            margin-bottom: 25px;
        }

        label {
            display: block;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 50px;
        }

        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 18px;
            border: none;
            cursor: pointer;
            width: 100%;
            border-radius: 50px;
        }
    </style>
</head>
 
            
<body>
<%! Object s; %>
 <% s = (String)application.getAttribute("currentDate"); %>
    <form action = "../FormServlet" method="post">
        <div class="form-group">
            <label for="date">Date:</label> <br>
            <input type="text" id="date" value = <%= s %> name="date">
        </div>
        <div class="form-group">
            <label for="phone">Phone Number:</label> <br>
            <input type="text" id="phone" name="phone">
        </div>
        <div class="form-group">
            <label for="city">City:</label> <br>
            <select id="citychoose" name="choosecity">
                <option value="CITY">Ur city</option>
            </select>
        </div>
        <div class="form-group">
            <label for="country">Country:</label> <br>
            <input type="text" id="country" name="choosecountry">
        </div>
        <br>
        <div class="form-group">
            <label for="violation">What violation would you like to report?</label> <br>
            <select id="violation" name="violation">
                <option value="Red light Crossing">Red light crossing</option>
                <option value="Running A Stop Sign">Running a stop sign</option>
                <option value="Jaywalking">Jaywalking</option>
                <option value="Littering">Littering</option>
            </select>
        </div>
        <div>
        <label for="mediaFile">Select a Picture or Video:</label>
        <input type="file" id="mediaFile" name="mediaFile" accept="image/*, video/*">
        </div>
        <br>
        <div class="form-group">
            <button type="submit">Submit</button>
        </div>
    </form>
</body>
</html>
