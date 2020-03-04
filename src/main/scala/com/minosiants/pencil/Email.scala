package com.minosiants.pencil

final case class Mailbox(value: String)   extends Product with Serializable
final case class From(value: Mailbox)     extends Product with Serializable
final case class To(value: List[Mailbox]) extends Product with Serializable
final case class Cc(value: List[Mailbox]) extends Product with Serializable

final case class Email(from: From, to: To, cc: Cc)
    extends Product
    with Serializable
