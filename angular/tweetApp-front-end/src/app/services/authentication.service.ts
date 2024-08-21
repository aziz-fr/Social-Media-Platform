import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  // private AUTH_URL= 'http://localhost:9001/api/v1.0/users/auth';
  private AUTH_URL = environment.apiUrl;
  constructor(private http: HttpClient) { }

  login(data: any): Observable <any> 
  {
    return this.http.post<any>(`${this.AUTH_URL}/login`, data);
  }

  register(data: any): Observable <any>
  {
    return this.http.post<any>(`${this.AUTH_URL}/register`, data);
  }

  setPassword(user:any): Observable<any>
  {
    return this.http.put<any>(`${this.AUTH_URL}/setpassword`, user);
  }

  logout()
  {
    localStorage.clear();
  }

  getToken(): boolean
  {
    if(localStorage.getItem('token'))
      {
        return true;
      }else
      {
        return false;
      }
  }

}
