$(document).ready(function(){
    //$('.container-first').show();
});

function next(next){
    console.log('TEST');
    $(document).ready(function(){
        //$(".container").hide();
        $(next).show();
    });
}

$(function(){
    var $foo = $('#foo');
    var $bar = $('#bar');
    function onChange() {
        $bar.val($foo.val());
    };
    $('#foo')
        .change(onChange)
        .keyup(onChange);
});

/*function setReason(reason){

    var $foo = $('#damageReason');
    var $bar = $('#input-damageSource');
    function onChange() {
        $bar.val($foo.val());
    };
    $('#foo')
            .change(onChange)
            .keyup(onChange);

    /*$(document).ready(function(){
        $("#input-damageSource").val(reason);
    });*/
    