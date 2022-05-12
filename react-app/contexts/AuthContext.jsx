import React, { createContext, useState, useEffect } from "react";

const AuthContext = createContext();

export function getRandomColor() {
  var letters = "0123456789ABCDEF";
  var color = "#";
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

const AuthContextProvider = ({ children }) => {
  const [isAuthenticated, setAuthenticated] = useState(false);
  const [user, setUser] = useState(null);
  const [isLoading, setLoading] = useState(false);

  async function signIn(name) {
    setUser({
      name: name,
      color: getRandomColor(),
    });
    setAuthenticated(true);
  }

  function signOut() {
    setUser(null);
    setAuthenticated(false);
  }

  return (
    <AuthContext.Provider
      value={{
        isAuthenticated,
        signIn,
        isLoading,
        user,
        signOut,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};
export { AuthContextProvider };
export default AuthContext;
