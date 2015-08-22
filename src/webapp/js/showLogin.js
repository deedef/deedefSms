/**
 * Created by S2D on 7/7/15.
 */

$('document').ready(function(){
    $('#home_login').css({display:'none'});

    $('#show_login').click(function(){
        $('#home_login').slideToggle('slow');
    });
});