import { Component, OnInit } from '@angular/core';
import { JhiWebSocketService } from '../service/web-socket/jhi-websocket-service';
import { AuthService } from '../service/auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private websocketService : JhiWebSocketService,
    private authenticationService: AuthService,
    private http: HttpClient) { }
json;
  ngOnInit() {
    const currentUser = this.authenticationService.currentUserValue;
    this.http.get<any>(`${environment.apiUrl}/api/token/me`).subscribe(data=>
      {
        console.log("User Name : "+JSON.stringify(data));
      });
   this.websocketService.connect(`Bearer ${currentUser.token}`);
   this.websocketService.subscribe();
   this.websocketService.receive().subscribe(
     data=>
     {
       console.log("subscribed data"+data);
     }
   );


  }

}
