<#import "layout.ftl" as layout>
<@layout.myLayout>   
 
<div class="leftBox" > 
    <ul class="list-group">
        <li class="list-group-item" id="userInfo" class="active"> User Info</li>
        <li class="list-group-item" id="changeUser">Change User Name</li>
        <li class="list-group-item" id="changePwd">Change Password</li>
    </ul>
</div>
<div class="centerBox" >
    <ul class="list-group" id="userInfoList">
        <li class="list-group-item">UserName: ${user.userName!}</li>
        <li class="list-group-item">FirstName: ${user.firstName!}</li>
        <li class="list-group-item">Lastname: ${user.lastName!}</li>
        <li class="list-group-item">Email: ${user.email!}</li>
        <li class="list-group-item">Version: ${user.version}</li>
        <li class="list-group-item">CreateAt: ${user.createdAt!}</li>
        <li class="list-group-item">UpdatedAt:${user.updatedAt!}</li>
    </ul>

    <form id="changeUser-form" action="/doChangeUser" method="post" role="form" style="display: none;">
        <div class="form-group">
            <input type="text" name="userName" id="username" tabindex="1" class="form-control" placeholder="User Name" value="">
        </div>
       <div class="form-group">
            <input type="text" name="firstName" id="firstname" tabindex="2" class="form-control" placeholder="First Name" value="">
        </div>
        <div class="form-group">
            <input type="text" name="lastName" id="lastname" tabindex="3" class="form-control" placeholder="Last Name" value="">
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <input type="submit" name="changUser-submit" id="changUser-submit" tabindex="4" class="form-control btn btn-login" value="Change User Name">
                </div>
            </div>
        </div>										
    </form>
    <div id="changePwd-form"  style="display: none;">
	  <#include "changePwd.ftl"/>
    </div>								
</div>

</@layout.myLayout>
