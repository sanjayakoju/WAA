import React, {useEffect, useState} from 'react';
import axios from "axios";
import {useNavigate, useParams} from "react-router-dom";

export const Books = (props) => {

    const [booklist, setBooklist] = useState([]);

    const navigate = useNavigate()

    useEffect(() => {
        loadData()
    })

    const loadData = () => {
        const books = axios.get("http://localhost:8080/books")
            .then((response) => {
                console.log('Response ', response.data)
                setBooklist(response.data);
            }).catch((error) => {
                console.log('Error : ',error)
            })
    }

    const addBook = () => {
        navigate('/addBook')
    }

    const removeBook = (e) => {
        const isbn = e.target.value;
        console.log('removing book isbn : ', 'http://localhost:8080/books/'+isbn);
        axios.delete('http://localhost:8080/books/'+isbn)
            .then((res) => {
                console.log('Remove book with ISBN : ',isbn);
                loadData();
            }).catch((err) => {
                console.log('Error : ',err)
        })
    }

    return (
        <div>
            <h5>Books</h5>
            <table border='2'>
                <thead>
                    <th>IBN</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Action</th>
                </thead>
                <tbody>
                {booklist.map(book => (
                    <tr key={book.isbn}>
                        <td>{book.isbn}</td>
                        <td>{book.title}</td>
                        <td>{book.price}</td>
                        <td>{book.author}</td>
                        <td><button onClick={removeBook} value={book.isbn}>Remove</button></td>
                    </tr>
                ))}
                </tbody>
            </table>
            <button onClick={loadData}>Load Book</button>
            <button onClick={addBook}>Add Book</button>
        </div>
    );
}

export default Books;

