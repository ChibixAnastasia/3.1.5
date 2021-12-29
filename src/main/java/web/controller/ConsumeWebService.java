package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import web.model.User;

import java.util.List;

@RestController
public class ConsumeWebService {

    private RestTemplate restTemplate;
    private String url = "http://91.241.64.178:7081/api/users";
@Autowired
    public ConsumeWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<List<User>> getAllUsers() {
        return restTemplate.exchange(url,HttpMethod.GET,null, new ParameterizedTypeReference<>(){});

    }
    public ResponseEntity<String> createUser(User user,String sessuon){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie",sessuon);
        return restTemplate.exchange(url,HttpMethod.POST,new HttpEntity<>(user,headers),String.class);
    }
    public ResponseEntity<String> edit(User user, String sessuon){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie",sessuon);
        return restTemplate.exchange(url,HttpMethod.PUT,new HttpEntity<>(user,headers),String.class);
    }
    public ResponseEntity<String> delitUser(User user, String sessuon){
        String urlId = url + "/"+user.getId();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie",sessuon);
        return restTemplate.exchange(urlId,HttpMethod.DELETE,new HttpEntity<>(user,headers),String.class);

    }
}

