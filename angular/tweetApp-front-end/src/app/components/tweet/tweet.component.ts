import { Component } from '@angular/core';
import { ITweet } from 'src/app/models/tweet.model';
import { Router } from '@angular/router';
import { DataService } from'src/app/services/data.service';
import { IUser } from 'src/app/models/user.model';
import { IReply } from 'src/app/models/reply.model';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-tweet',
  templateUrl: './tweet.component.html',
  styleUrls: ['./tweet.component.css']
})
export class TweetComponent {

  tweets: ITweet[] = [];
  replies: IReply[] = [];
  
  users: IUser[]=[];
  username = localStorage.getItem('username');

  constructor(private dataService: DataService ,private router: Router, private formBuilder: FormBuilder) 
  {
    this.dataService.getTweets().subscribe((response: ITweet[])=>{
      // this.tweets = response;
      this.tweets = response.map(tweet => ({...tweet, showReplySection: false, replyText:''}));
      
    });
    this.dataService.getUsers().subscribe((response: IUser[])=>{
      this.users = response;
    });

    this.dataService.getReplies().subscribe((response: IReply[])=>{
      this.replies = response;
      
    });
    
   }

   replyForm = this.formBuilder.group({
    content: ['', Validators.maxLength(80)],
    date: [new Date()],
    userId:[localStorage.getItem('id')],
    tweetId:['']
   });

   get content() 
   {
     return this.replyForm.get('content');
   }
   get tweetId()
   {
     return this.replyForm.get('tweetId');
   }
   

   onClickHandler(tweet: ITweet)
   {
    //  this.router.navigate(['/tweets']);
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
      
      
     this.dataService.postReply(tweet.id, newReply).subscribe();
      tweet.replyText='';
      tweet.showReplySection =false;
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
  
    // this.dataService.postReply(tweet.id, newReply).subscribe();

    //post reply to database
    // this.replies.push(newReply);
    // this.replies.push(newReply);
    tweet.replyText='';
    tweet.showReplySection =false;

    

    
   }

}
