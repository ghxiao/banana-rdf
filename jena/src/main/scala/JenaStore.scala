package org.w3.rdf.jena

import org.w3.rdf._

object JenaStore extends RDFStore[Jena] {

  import JenaOperations._

  def addNamedGraph(store: Jena#Store, uri: Jena#IRI, graph: Jena#Graph): Jena#Store = {
    store.removeGraph(uri)
    store.addGraph(uri, graph)
    store
  }

  def appendToNamedGraph(store: Jena#Store, uri: Jena#IRI, graph: Jena#Graph): Jena#Store = {
    Graph.toIterable(graph) foreach { case Triple(s, p, o) =>
      store.add(uri, s, p, o)
    }
    store
  }

  def getNamedGraph(store: Jena#Store, uri: Jena#IRI): Jena#Graph = {
    store.getGraph(uri)
  }

  def removeGraph(store: Jena#Store, uri: Jena#IRI): Jena#Store = {
    store.removeGraph(uri)
    store
  }

}
