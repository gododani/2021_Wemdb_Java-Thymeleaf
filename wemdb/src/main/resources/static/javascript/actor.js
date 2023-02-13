$(document).ready(function (){
    let addButton = $('#actorAdd');
    let resetButton = $('#actorInputReset');
    let leftHTML = $('#actorName');
    let newLeftHTML = '' +
        '<div class="leftDelete">' +
        '<span class="actorName" style="margin-left: 10px">Név:</span>' +
        '<input type="text" name="actorName" required style="width: 80%; margin: 0 0 20px 10px">' +
        '</div>';

    let rightHTML = $('#characterName');
    let newRightHTML = '' +
        '<div class="rightDelete">' +
        '<span class="characterName" style="margin-left: 10px">Karakter:</span>' +
        '<input type="text" name="characterName" required style="width: 80%; margin: 0 0 20px 10px">' +
        '<button type=\"button\" class=\"btn btn-danger modal-button\" id=\"actorCancel\" style="float: right">-</button></div>';

    $(addButton).click(function (){
        $('#characterName #actorCancel:last').remove()
        leftHTML.append(newLeftHTML);
        rightHTML.append(newRightHTML);
    });

    $(rightHTML).on('click', '#actorCancel',function (e){
        e.preventDefault();
        $('#characterName .rightDelete:last').remove()
        $('#actorName .leftDelete:last').remove()
        $('#characterName .rightDelete:last').append("" +
            "<button type=\"button\" class=\"btn btn-danger modal-button\" id=\"actorCancel\" style=\"float: right\">-</button>");
    });

    $(resetButton).click(function (){
        $('#actorName .leftDelete').remove()
        $('#characterName .rightDelete').remove()
    });
});