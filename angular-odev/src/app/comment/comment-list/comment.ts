export interface Comments {
    comment_id: number,
    post_id: number,
    user_id: number | string,
    comment: string,
    creation_date: string,
    is_confirmed: boolean
}