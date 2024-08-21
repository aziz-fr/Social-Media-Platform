import { IUser } from "./user.model";

export interface ITweet
{
    id: number;
    content: string;
    date: Date;
    userId: number;
    showReplySection: boolean;
    replyText: string;
}