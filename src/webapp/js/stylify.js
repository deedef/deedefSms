/**
 * Created by S2D on 7/7/15.
 */

$('document').ready(function(){
    //$('.home_content > span').on('mouseover', animateHomeContent);
});

function animateHomeContent(){
    $(this)
        .animate({fontSize: '+=3pt'},'fast','swing')
        .fadeTo(0.5)
        .fadeTo(1.0)
        .animate({fontSize: '-=3pt'},'fast','swing');
}
