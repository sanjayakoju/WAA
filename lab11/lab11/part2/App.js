import './App.css';
import {useState} from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {BookList} from "./pages/BookList";
import {AddBook} from "./pages/AddBook";

function App() {

  const initialBookList = [
    {isbn: "1234", title: "Java Complete Reference", author: "James Goasling", price: "120.0"},
    {isbn: "2345", title: "Angular Complete reference", author: "Jhon", price: "220.0"},
    {isbn: "3456", title: "Node JS", author: "Angelina", price: "320.0"},
    {isbn: "4567", title: "React Complete", author: "James", price: "420.0"},
  ]

  const [bookList, setBookList] = useState(initialBookList);

  const onAddBook = (book) => {
    setBookList(bookList.concat(book));
  }

  const onRemoveBook = (isbn) => {
    setBookList(bookList.filter((book) => book.isbn !== isbn))
  }



  return (
    <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<BookList bookList={bookList} removeBookFunction={onRemoveBook}/>}/>
            <Route path="/addBook" element={<AddBook addBookFunction={onAddBook}/>}/>
          </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
