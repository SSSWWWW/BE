/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ajax(config){  
    var req = new XMLHttpRequest();
    req.open( config.method, config.url, true );
    if(config.method==="POST"){
        req.setRequestHeader("Content-Type", "application/json");
    }    
    req.setRequestHeader("Accept", "application/json");
    req.onreadystatechange = function(){
        if( req.readyState === 4){ // terminada
            switch (req.status){
                case 200: // ok with response content
                    config.success(JSON.parse(req.responseText));
                    break;
                case 204: // ok with NO response content
                    config.success();
                    break;
                default:
                    if(config.error){
                        config.error(req.status);
                    };
                    break;                    
            }
        }
    };
    if(config.data){
        req.send(JSON.stringify(config.data)); 
    }
    else{
        req.send(); 
    }
}