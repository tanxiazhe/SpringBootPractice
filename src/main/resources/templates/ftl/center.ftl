<#import "layout.ftl" as layout>
<@layout.myLayout>

    ${message} ${userName}
    <br/>
    </br>

    <table border="1px solid #8968CD" style="border-collapse: collapse;">
    <tr><th>id</th> <th>name</th> <th>version</th> <th>createdAt</th> <th>updatedAt</th> </tr>  
        <#list conferenceList as conference>  
            <tr>  
                <td>${conference.id}</td>  
                <td>${conference.name!}</td>  
                <td>${conference.version}</td>  
                <td>${conference.createdAt!}</td>  
                <td>${conference.updatedAt!}</td>  
            </tr>  
        </#list>  
    </table>  
   

</@layout.myLayout>
