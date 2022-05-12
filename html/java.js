
/*$(document).ready(function(){  
    $("#suggest").keyup(function(){  
        $.get("suggest.php", {company: $(this).val()}, function(data){  
            $("datalist").empty();  
            $("datalist").html(data);  
        });  
    });  
});  

function myFunction() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById("userInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("ingList");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}


/*function saveStaticDataToFile() {

var input = document.getElementById('userInput').value;


alert(input)
}*/