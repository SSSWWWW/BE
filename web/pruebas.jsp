<%-- 
    Document   : registroempresa
    Created on : Mar 17, 2018, 1:30:57 PM
    Author     : pc

AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA
--%>



<%@page import="entidades.Especializacion"%>
<%@page import="entidades.Area_Trabajo"%>
<%@page import="logica.model"%>
<%@page import="entidades.Caracteristicas"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    
      <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<form id="signupForm" method="post" class="form-horizontal">
    <div class="form-group">
        <label class="col-xs-3 control-label">Full name</label>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="firstName" placeholder="First name" />
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="lastName" placeholder="Last name" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Username</label>
        <div class="col-xs-5">
            <input type="text" class="form-control" name="username" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Email address</label>
        <div class="col-xs-5">
            <input type="text" class="form-control" name="email" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Password</label>
        <div class="col-xs-5">
            <input type="password" class="form-control" name="password" />
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Gender</label>
        <div class="col-xs-5">
            <div class="radio">
                <label>
                    <input type="radio" name="gender" value="male" /> Male
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" value="female" /> Female
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" value="other" /> Other
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Bio</label>
        <div class="col-xs-8">
            <textarea class="form-control" name="bio" rows="5" style="width: 100%"></textarea>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-9 col-xs-offset-3">
            <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Sign up</button>
        </div>
    </div>
</form>

<!-- Modal for displaying the messages -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Errors</h5>
            </div>

            <div class="modal-body">
                <!-- The messages container -->
                <ul id="errors"></ul>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
$(document).ready(function() {
    $('#signupForm')
        .formValidation({
            framework: 'bootstrap',
            err: {
                container: '#errors'
            },
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                firstName: {
                    row: '.col-xs-4',
                    validators: {
                        notEmpty: {
                            message: 'The first name is required'
                        }
                    }
                },
                lastName: {
                    row: '.col-xs-4',
                    validators: {
                        notEmpty: {
                            message: 'The last name is required'
                        }
                    }
                },
                username: {
                    validators: {
                        notEmpty: {
                            message: 'The username is required'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: 'The username must be more than 5 and less than 31 characters long'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: 'The username can only consist of alphabetical, number, dot and underscore'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'The email address is required'
                        },
                        emailAddress: {
                            message: 'The email address is not valid'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required'
                        },
                        different: {
                            field: 'username',
                            message: 'The password cannot be the same as username'
                        }
                    }
                },
                gender: {
                    validators: {
                        notEmpty: {
                            message: 'The gender is required'
                        }
                    }
                },
                bio: {
                    validators: {
                        stringLength: {
                            max: 300,
                            message: 'The bio must be less than 300 characters long'
                        }
                    }
                }
            }
        })
        .on('success.form.fv', function(e) {
            // Reset the message element when the form is valid
            $('#errors').html('');
        })
        .on('err.field.fv', function(e, data) {
            // data.fv      --> The FormValidation instance
            // data.field   --> The field name
            // data.element --> The field element

            // Get the messages of field
            var messages = data.fv.getMessages(data.element);

            // Remove the field messages if they're already available
            $('#errors').find('li[data-field="' + data.field + '"]').remove();

            // Loop over the messages
            for (var i in messages) {
                // Create new 'li' element to show the message
                $('<li/>')
                    .attr('data-field', data.field)
                    .wrapInner(
                        $('<a/>')
                            .attr('href', 'javascript: void(0);')
                            .html(messages[i])
                            .on('click', function(e) {
                                // Hide the modal first
                                $('#messageModal').modal('hide');

                                // Focus on the invalid field
                                data.element.focus();
                            })
                    )
                    .appendTo('#errors');
            }

            // Hide the default message
            // data.element.data('fv.messages') returns the field messages element
            data.element
                .data('fv.messages')
                .find('.help-block[data-fv-for="' + data.field + '"]')
                .hide();
        })
        .on('success.field.fv', function(e, data) {
            // Remove the field messages
            $('#errors').find('li[data-field="' + data.field + '"]').remove();
        })
        .on('err.form.fv', function(e) {
            // Show the message modal
            $('#messageModal').modal('show');
        });
});
</script>


    
</body>
</html>