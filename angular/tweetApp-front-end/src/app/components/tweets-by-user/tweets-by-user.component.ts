import { Component } from '@angular/core';
import { ITweet } from 'src/app/models/tweet.model';
import { Router } from '@angular/router';
import { DataService } from'src/app/services/data.service';
import { IReply } from 'src/app/models/reply.model';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-tweet-by-user',
  templateUrl: './tweets-by-user.component.html',
  styleUrls: ['./tweets-by-user.component.css']
})
export class TweetsByUserComponent {

  // showReplySection: boolean = false;
  // replyText: string = '';

  tweets: ITweet[] = [];
 replies: IReply[] = [];
  
  username = localStorage.getItem('username');
  id = localStorage.getItem('id');
  constructor(private formBuilder: FormBuilder,private dataService: DataService ,private router: Router) 
  {
    
    this.dataService.getTweetsByUser(this.id).subscribe((response: ITweet[])=>{
      // this.tweets = response;
      this.tweets = response.map(tweet => ({...tweet, showReplySection: false, replyText:''}));
     
        });

        
   }

    

   onClickHandler(id: any)
   {
     this.router.navigate(['/profile']);
   }

   toggleReply(tweet: ITweet)
   {
      tweet.showReplySection = !tweet.showReplySection;
   }

   submitReply(tweet: ITweet)
   {
     let idString = localStorage.getItem('id');
     let idNumber = -1;
     if(idString)
      {
        idNumber = parseInt(idString,10);
      }

    const newReply = {
      content: tweet.replyText,
      date: new Date(),
      userId: idNumber,
      tweetId: tweet.id
    }
    //post reply to database
    // this.replies.push(newReply);
    this.replies.push(newReply);
    tweet.replyText='';
    tweet.showReplySection =false;
    
   }
   

}
