$(document).ready(() => {
    $("#pwd-toggler").on("click", function(event){
        event.preventDefault();
        if(document.getElementById("email").disabled === false){
            document.getElementById("email").disabled = true;
            document.getElementById("userName").disabled = true;
            document.getElementById("jelszo").disabled = true;
            document.getElementById("jelszoUjra").disabled = true;
            document.getElementById("profil").hidden = true;
            document.getElementById("profil-warning").hidden = true;
        }
        else{
            document.getElementById("email").disabled = false;
            document.getElementById("userName").disabled = false;
            document.getElementById("jelszo").disabled = false;
            document.getElementById("jelszoUjra").disabled = false;
            document.getElementById("profil").hidden = false;
            document.getElementById("profil-warning").hidden = false;
        }
    });
});