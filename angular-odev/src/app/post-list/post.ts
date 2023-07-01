export interface Posts {
    post_id: number,
    user_id: number,
    category_id: number,
    title: string,
    content: string,
    view_count: number,
    creation_date: string,
    is_published: boolean
}