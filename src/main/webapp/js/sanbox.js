//var DOMAIN = "http://najback-jhuska.rhcloud.com";
var DOMAIN = "http://localhost:8080/BPM-PV207";
var URL_PATTERN = "/rest";
var URL = DOMAIN + URL_PATTERN;

$( document ).ready( function() {
    $( '#foundOutInfo' ).click( function( event ) {
        event.preventDefault();

        var result = $( '#result' ),
            userId = $.trim( $( '#number' ).val() );

        $.ajax( {
            url: URL + '/users/' + userId,
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            data:{},
            type:'GET',
            success: function ( data ) {
                result.empty();
                result.append("Meno: <b>" + data.userName + "</b> </ br> Banned: <b>" + data.banned + "</b>");   
            }
        });
    });
    
    $( '#banUser' ).click( function( event ) {
        event.preventDefault();

        var result = $( '#result' ),
            userId = $.trim( $( '#number' ).val() );
        
        $.ajax( {
            url: URL + '/users/ban/' + userId,
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            data:{},
            type:'PUT',
            success: function ( data ) {
                result.empty();
                result.append("Uzivatel: " + userId + " bol zabanovany!");   
            }
        });
    });
    $( '#createBill' ).click( function( event ) {
        event.preventDefault();

        var result = $( '#result' ),
            userId = $.trim( $( '#number' ).val() );
        
        $.ajax( {
            url: URL + '/bills',
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            data: formToJSONBill(),
            type:'POST',
            success: function ( data ) {
                result.empty();
                result.append("Blocik pre uzivatela: " + userId + " bol vytvoreny!");   
            }
        });
    });
    $( '#foundOutInfoBill' ).click( function( event ) {
        event.preventDefault();

        var result = $( '#result' ),
            billId = $.trim( $( '#numberBill' ).val() );
        
        $.ajax( {
            url: URL + '/bills/'  + billId,
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            data: {},
            type:'GET',
            success: function ( data ) {
                result.empty();
                result.append("Blocik: " + data.billId + ", uzivatel: " + data.appUser.appUserId + ", dovod nakupu: " + data.forWhat);   
            }
        });
    });
    
    /*$( '#allEvents' ).click( function( event ) {
        event.preventDefault();

        var result = $( '#result' );

        $.ajax( {
            url: URL + '/events',
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            data:{},
            type:'GET',
            success: function ( data ) {
                $('#result').empty();
                $.each(data, function(index, element) {
                    $('#result').append($('<div>', {
                        text : element.id + '  :  ' + element.name + '  :  ' + element.description
                    }));
                });
            }
        });
    });
    $( '#deleteEvent' ).click( function( event ) {        
            event.preventDefault();
            var url = URL + '/events/' + $('#numberToBeDeleted').val();
            var method = 'DELETE';
                    
            console.log("Preparing to make HTTP " + method + " request to " + url);
            if (XMLHttpRequest === null) {
                console.log("Browser doesn't support XMLHttpRequest");
                return;
            }
                    
            var request = new XMLHttpRequest();
                                
            request.open(method, url);
            
            request.onreadystatechange = function() {
                if (this.readyState == 3) {
                    console.log("Received response headers");
                }
                if (this.readyState == 4) {
                    console.log("Request completed with HTTP status " + this.status);
                }
            } 
            request.send();
            console.log("Request sent");
        });

    $( '#newEventButton' ).click(function (event) {
        event.preventDefault();
        
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: URL + '/events',
            dataType: "json",
            data: formToJSON(),
            success: function(data, textStatus, jqXHR){
                alert('Eventa vytvorena!');
                alert('Nova eventa ma id:' + data.id);
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert('error: ' + textStatus);
            }
        });
    });*/

    // Helper function to serialize all the form fields into a JSON string
    function formToJSONBill() {
        return JSON.stringify({
            "appUser": {appUserId : $('#number').val()},
            "forWhat": $('#forWhat').val(),
        });
    }
}); // (document).ready
