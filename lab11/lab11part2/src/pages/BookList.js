import React from "react";
import {useNavigate} from "react-router-dom";

export const BookList = ({bookList, removeBookFunction}) => {

    const navigate = useNavigate()

    const handleAddBook = () => {
        navigate('/addBook')
    }

    const removeBook = (e) => {
        removeBookFunction(e.target.value);
    }

    return (
        <div>
            <h1>Books</h1>
            <table>
                <thead>
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                {bookList.map(book => (
                    <tr key={book.isbn}>
                        <td>{book.isbn}</td>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td>{book.price}</td>
                        <td><button onClick={removeBook} value={book.isbn}>Remove</button></td>
                    </tr>
                ))}
                </tbody>
            </table>
            <button onClick={handleAddBook}>Add Book</button>
        </div>
    );
}

export default BookList;