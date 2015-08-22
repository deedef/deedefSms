/**
 * Created by S2D on 6/7/15.
 */

$('document').ready(function(){
    $('#left_menu > a[id=dashboard]').addClass('active');
});

function resetInactive(){
    var leftnav = $('#left_menu > a[id]');
    _.each(leftnav,function(navlink){
        $(navlink).removeClass('active').addClass('inactive');
    });
}