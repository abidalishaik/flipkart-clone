import "./App.css";

import NavBar from "./components/NavBar";
import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <NavBar />
    </div>
  );
}

export default App;
