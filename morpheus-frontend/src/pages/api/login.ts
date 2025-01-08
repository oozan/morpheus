import type { NextApiRequest, NextApiResponse } from "next";

type LoginResponse = {
  success: boolean;
  message?: string;
};

export default function handler(
  req: NextApiRequest,
  res: NextApiResponse<LoginResponse>
) {
  if (req.method === "POST") {
    const { email, password } = req.body;
    if (email === "test@example.com" && password === "password") {
      res.status(200).json({ success: true });
    } else {
      res.status(401).json({ success: false, message: "Invalid credentials" });
    }
  } else {
    res.status(405).end(); // Method Not Allowed
  }
}
