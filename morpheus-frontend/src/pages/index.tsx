import { useState, useEffect } from 'react';

export default function Home() {
  const [message, setMessage] = useState<string>('');

  useEffect(() => {
    fetch('/api/message')
      .then((response) => response.json())
      .then((data) => setMessage(data.message));
  }, []);

  return (
    <div className="flex flex-col items-center justify-center h-screen bg-gray-100">
      <h1 className="text-4xl font-bold text-gray-800">Welcome to Morpheus</h1>
      <p className="mt-4 text-lg text-gray-600">{message || 'Loading...'}</p>
    </div>
  );
}