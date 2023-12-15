import "./App.css";

import FocusArea from "./components/QuickMenu";
import NavBar from "./components/Header/NavBar";
import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <NavBar />
      <FocusArea />
    </div>
  );
}

export default App;
