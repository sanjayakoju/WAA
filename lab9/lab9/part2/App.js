import './App.css';
import ButtonComponentFunction from "./ButtonComponentFunction";

function App() {
  return (
    <div>
      <header>
          <ButtonComponentFunction name="Say Hello from Button 1"/>
          <ButtonComponentFunction name="Say Welcome from Button 2"/> <br/>
          <ButtonComponentFunction name="Say Hi from Button 3"/>
          <ButtonComponentFunction name="Say Good bye from Button 4"/>
      </header>
    </div>
  );
}

export default App;
