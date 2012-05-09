package org.w3.banana.jena

import org.w3.banana._
import com.hp.hpl.jena.sparql.core._

class JenaStoreTest() extends StoreTest[Jena](
  JenaOperations,
  JenaDiesel,
  JenaGraphUnion,
  JenaStore,
  JenaRDFXMLReader,
  JenaGraphIsomorphism) {

  val store: DatasetGraph = DatasetGraphFactory.createMem()

  import JenaOperations._
  import JenaStore._

  "adding a named graph should not pollute the default graph" in {
    addNamedGraph(store, IRI("http://example.com/foo"), graph)
    val defaultGraph = getNamedGraph(store, null.asInstanceOf[Jena#IRI])
    defaultGraph must have size(0)
  }

}