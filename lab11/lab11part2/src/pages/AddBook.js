import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
export const AddBook = ({addBookFunction}) => {

    const navigate = useNavigate()
    const clearBook = {isbn: "", title: "", author: "", price: ""}
    const [book, setBook] = useState(clearBook)

    const handleSubmit = (e) => {
        e.preventDefault();
        addBookFunction(book);
        navigate('/')
    }

    const handleFieldChange = (e) => {
        setBook({...book, [e.target.name]: e.target.value});
    }

    return (
        <div>
            <h1>Add a Book</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    ISBN
                    <input
                        type="text"
                        placeholder="ISBN"
                        name="isbn"
                        value={book.isbn}
                        onChange={handleFieldChange}
                    />
                </div>
                <div>
                    Title
                    <input
                        type="text"
                        placeholder="Title"
                        name="title"
                        value={book.title}
                        onChange={handleFieldChange}
                    />
                </div>
                <div>
                    Author
                    <input
                        type="text"
                        placeholder="Author"
                        name="author"
                        value={book.author}
                        onChange={handleFieldChange}
                    />
                </div>
                <div>
                    Price
                    <input
                        type="number"
                        placeholder="Price"
                        name="price"
                        value={book.price}
                        onChange={handleFieldChange}
                    />
                </div>
                <button type="submit">Add Book</button>
            </form>
        </div>
    )
}

export default AddBook