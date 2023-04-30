import React, {useState} from 'react';
import axios from "axios";
import {useNavigate} from "react-router-dom";

export const AddBook = (props) => {

    const cleanBook = {
        isbn: "",
        title: "",
        price: "",
        author: ""
    }
    const [book, setBook] = useState(cleanBook)
    const [isbnError, setIsbnError] = useState({});
    const [titleError, setTitleError] = useState({});
    const [priceError, setPriceError] = useState({});
    const [authorError, setAuthorError] = useState({})

    const navigate = useNavigate()
    const addBook = (book) => {
        axios.post('http://localhost:8080/books', book)
            .then((res) => {
                console.log('Response : ', res.data);
            }).catch((err) => {
                console.log('Error : ',err)
        })
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log('Handle Click')
        const isValid = formValidation();
        console.log("IsValid : ", isValid)
        if(isValid) {
            if(book) {
                console.log('Call Server')
                console.log('Book :', book)
                addBook(book)
                navigate('/')
            }
            setBook(cleanBook);
        }
    }

    const formValidation = () => {
        const isbnErr = {};
        const titleErr = {};
        const priceErr = {};
        const authorErr = {};
        let isValid = false;

        if(book.isbn.trim().length < 2) {
            isbnErr.isbn = "ISBN is too short"
            isValid = false
        }
        if(book.author.trim().length < 3) {
            authorErr.author = "Author name is too short"
            isValid = false
        }
        if(book.title.trim().length < 4) {
            titleErr.title = "Title of book is too short"
            isValid = false
        }
        if(book.price.trim().length < 1) {
            priceErr.price = "Price must not be empty"
            isValid = false
        }
        setIsbnError(isbnErr)
        setPriceError(priceError)
        setAuthorError(authorErr)
        setTitleError(titleErr)

        return isValid
    }

    const handleFieldChange = (e) => {
        setBook({...book,[e.target.name]: e.target.value})
    }

    return (
        <div>
            <h4>Add a new Book</h4>
            <form onSubmit={handleSubmit}>
                <div>
                    Isbn:
                    <input
                        type='text'
                        placeholder='Isbn'
                        name='isbn'
                        value={book.isbn}
                        onChange={handleFieldChange}
                    />
                    {Object.keys(isbnError).map((key) => {
                        return <div style={{color: "red"}}>{isbnError[key]}</div>
                        })}
                </div>
                <div>
                    Title:
                    <input
                        type='text'
                        placeholder='Title'
                        name='title'
                        value={book.title}
                        onChange={handleFieldChange}
                    />
                    {Object.keys(titleError).map((key) => {
                        return <div style={{color: "red"}}>{titleError[key]}</div>
                    })}
                </div>
                <div>
                    Price:
                    <input
                        type='text'
                        placeholder='Price'
                        name='price'
                        value={book.price}
                        onChange={handleFieldChange}
                    />
                    {Object.keys(priceError).map((key) => {
                        return <div style={{color: "red"}}>{priceError[key]}</div>
                    })}
                </div>
                <div>
                    Author:
                    <input
                        type='text'
                        placeholder='Author'
                        name='author'
                        value={book.author}
                        onChange={handleFieldChange}
                    />
                    {Object.keys(authorError).map((key) => {
                        return <div style={{color: "red"}}>{authorError[key]}</div>
                    })}
                </div>
              <button type="submit">Add book</button>
            </form>
        </div>
    );
}

export default AddBook;