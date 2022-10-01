import { useState, useEffect } from "react";

const useInfiniteScroll = (callback) => {
  const [isFetching, setIsFetching] = useState(false);

  useEffect(() => {
    window.addEventListener("scroll", handleScroll);

    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  useEffect(() => {
    if (!isFetching) return;
    callback(() => {
      console.log("Fetch more....");
    });
  }, [callback, isFetching]);

  function handleScroll() {
    if (
      Math.ceil(window.innerHeight + document.documentElement.scrollTop) !==
      document.documentElement.offsetHeight
    )
      return;
    setIsFetching(true);
  }

  return [setIsFetching];
};

export default useInfiniteScroll;