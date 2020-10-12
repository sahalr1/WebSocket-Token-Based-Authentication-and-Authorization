import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthInterceptorService } from './service/interceptor/auth-interceptor.service';
import { AuthService } from './service/auth.service';
import { JhiWebSocketService } from './service/web-socket/jhi-websocket-service';
@NgModule({
  declarations: [
    AppComponent,
      LoginComponent,
      HomeComponent
   ],
  imports: [

  BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true }
  ,AuthService,JhiWebSocketService],
  bootstrap: [AppComponent]
})
export class AppModule { }
