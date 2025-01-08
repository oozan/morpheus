import type { NextApiRequest, NextApiResponse } from "next";

type MessageResponse = {
  message: string;
};

export default function handler(
  req: NextApiRequest,
  res: NextApiResponse<MessageResponse>
) {
  res.status(200).json({ message: "Hello from Morpheus backend!" });
}
