<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <input id="parameter1" placeholder="First parameter">
        <select id="operation">
            <option value="0">+</option>
            <option value="1">-</option>
            <option value="2">*</option>
            <option value="3">/</option>
            <option value="4">%</option>
            <option value="5">^</option>
        </select>
        <input id="parameter2" placeholder="Second parameter">
        <button id="btn">Get Result</button>
        <span id="result"></span>
        <a href="Calculator">sdfsdf</a>
        <script type = "text/javascript" src = "jquery-2.2.0.min.js"></script>
        
        <script>
            $(document).ready(function() {                   
                $('#btn').click(function() { 
                    var parameter1 = $('#parameter1').val(),
                        parameter2 = $('#parameter2').val(),
                        operation = $('#operation').val(),
                        inputObj = { 
                           parameter1: parameter1, 
                           parameter2: parameter2, 
                           operation: operation 
                        };
                    
                    $.ajax({
                        type: "post",                                     
                        url: "Calculator",                                
                        data: inputObj,  
                        success: function(answer) {
                               $('#result').text("Result: " + answer);
                            }
                    });
                    return false;                                                            
                });
            });           
        </script>    
    </body>
</html>
