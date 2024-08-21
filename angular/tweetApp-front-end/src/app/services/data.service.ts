import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ITweet } from '../models/tweet.model';
import { Observable } from 'rxjs';
import { IUser } from '../models/user.model';
import { IReply } from '../models/reply.model';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  // BASE_URL = 'http://localhost:9090/api/v1.0';
  BASE_URL = environment.baseUrl;

  constructor(private http: HttpClient) {}

  getTweets(): Observable<ITweet[]> {
    return this.http.get<ITweet[]>(`${this.BASE_URL}/tweets/all`);
  }

  postTweet(id: any, tweet: any): Observable<any> {
    // return this.http.post<any>(`http://localhost:9002/api/v1.0/tweets/${id}/add`, tweet);
    return this.http.post<any>(`http://localhost:9090/api/v1.0/tweets/${id}/add`, tweet);
  }

  getTweetsByUser(id: any): Observable<ITweet[]> {
    return this.http.get<ITweet[]>(`${this.BASE_URL}/tweets/${id}`);
  }

  getUsers()
  {
    return this.http.get<IUser[]>(`${this.BASE_URL}/users/all`);
  }

  getUserById(id: any): Observable<IUser> 
  {
    return this.http.get<IUser>(`${this.BASE_URL}/users/${id}`);
  }

  postReply(tweetId: any, reply: any): Observable<any> 
  {
    return this.http.post<any>(`http://localhost:9004/api/v1.0/reply/${tweetId}/add`, reply);
  }

  getReplies(): Observable<IReply[]>
  {
    return this.http.get<IReply[]>(`${this.BASE_URL}/reply`);
  }

}
