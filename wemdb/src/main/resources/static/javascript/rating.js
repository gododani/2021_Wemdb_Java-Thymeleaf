document.addEventListener('DOMContentLoaded', function(){
    addListeners();
    setRating(); //based on value inside the div
});

window.onload = function (e) {
    checkRating();
    checkReviewRating();
}

function checkRating() {
    const starRating = document.querySelector('.updateRatingstars').getAttribute('data-rating');
    let stars = document.querySelectorAll('.updateRatingstar');

    [].forEach.call(stars, function(star, index){
        if(starRating > index){
            star.classList.add('rated');
        }else{
            star.classList.remove('rated');
        }
    });
}

function checkReviewRating() {
    const starRating = document.querySelector('.updateReviewstars').getAttribute('data-rating');
    let stars = document.querySelectorAll('.updateReviewstar');

    [].forEach.call(stars, function(star, index){
        if(starRating > index){
            star.classList.add('rated');
        }else{
            star.classList.remove('rated');
        }
    });
}

function addListeners(){
    var stars = document.querySelectorAll('.star');
    [].forEach.call(stars, function(star, index){
        star.addEventListener('click', (function(idx){
            document.querySelector('.stars').setAttribute('data-rating',  idx + 1);
            setRating();
        }).bind(window,index) );
    });
}

function setRating(){
    var stars = document.querySelectorAll('.star');
    var rating = parseInt( document.querySelector('.stars').getAttribute('data-rating'));
    [].forEach.call(stars, function(star, index){
        if(rating > index){
            star.classList.add('rated');
        }else{
            star.classList.remove('rated');
        }
    });
}

$(document).ready(() => {
    $("#ert-visszajel-success-bezar").on("click", function(event){
        $('.ratingAdd').css('display', 'none');
    });

    $("#ert-visszajel-error-bezar").on("click", function(event){
        $('.ratingAdd').css('display', 'none');
    });
    $("#kritika-visszajel-success-bezar").on("click", function(event){
        $('.reviewAdd').css('display', 'none');
    });

    $("#kritika-visszajel-error-bezar").on("click", function(event){
        $('.reviewAdd').css('display', 'none');
    });
})