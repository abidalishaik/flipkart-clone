import "./App.css";

import NavBar from "./components/Header/NavBar";
import QuickMenu from "./components/QuickMenu";
import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <NavBar />
      <QuickMenu />
    </div>
  );
}

export default App;
